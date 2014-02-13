package org.sugarj;

import static org.sugarj.common.ATermCommands.getApplicationSubterm;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.sugarj.common.ATermCommands;
import org.sugarj.common.CommandExecution;
import org.sugarj.common.CommandExecution.ExecutionError;
import org.sugarj.common.Environment;
import org.sugarj.common.FileCommands;
import org.sugarj.common.Log;
import org.sugarj.common.StringCommands;
import org.sugarj.common.path.AbsolutePath;
import org.sugarj.common.path.Path;
import org.sugarj.common.path.RelativePath;

/**
 * @author Matthias Becker
 */
public class CProcessor extends AbstractBaseProcessor {

	private static final long serialVersionUID = -7138788799109040850L;

	// private String moduleHeader;
	private List<String> imports = new LinkedList<String>();
	private List<String> body = new LinkedList<String>();
	// private boolean hasExtension = false;

	private Environment environment;
	private RelativePath sourceFile;
	private Path outCFile;
	private Set<RelativePath> generatedModules = new HashSet<RelativePath>();

	private String moduleName;

	private IStrategoTerm ppTable;

	@Override
	public String getGeneratedSource() {

		//String tmp = StringCommands.printListSeparated(imports, "\n") + "\n" + StringCommands.printListSeparated(body, "\n");

		System.out.println("///////////" + body);
		
		String tmp = "int main() { }";
		return tmp;
	}

	@Override
	public Path getGeneratedSourceFile() {
		return outCFile;
	}

	@Override
	public String getNamespace() {
		return "";
	}

	@Override
	public CLanguage getLanguage() {
		return CLanguage.getInstance();
	}

	/*
	 * processing stuff follows here
	 */
	@Override
	public void init(RelativePath sourceFile, Environment environment) {
		this.environment = environment;
		this.sourceFile = sourceFile;
		outCFile = environment.createOutPath(FileCommands.dropExtension(sourceFile.getRelativePath()) + "." + CLanguage.getInstance().getBaseFileExtension());
	}

	// private void processNamespaceDecl(IStrategoTerm toplevelDecl) throws IOException {
	// String qualifiedModuleName = prettyPrint(getApplicationSubterm(toplevelDecl, "ModuleDec", 0));
	// String qualifiedModulePath = qualifiedModuleName.replace('.', '/');
	// String declaredModuleName = FileCommands.fileName(qualifiedModulePath);
	// moduleName = FileCommands.dropExtension(FileCommands.fileName(sourceFile.getRelativePath()));
	// String declaredRelNamespaceName = FileCommands.dropFilename(qualifiedModulePath);
	// relNamespaceName = FileCommands.dropFilename(sourceFile.getRelativePath());
	//
	// RelativePath objectFile = environment.createOutPath(getRelativeNamespaceSep() + moduleName + "." + CLanguage.getInstance().getBinaryFileExtension());
	// generatedModules.add(objectFile);
	//
	// moduleHeader = prettyPrint(toplevelDecl);
	//
	// if (!declaredRelNamespaceName.equals(relNamespaceName))
	// throw new RuntimeException("The declared namespace '" + declaredRelNamespaceName + "'" + " does not match the expected namespace '" + relNamespaceName + "'.");
	//
	// if (!declaredModuleName.equals(moduleName))
	// throw new RuntimeException("The declared module name '" + declaredModuleName + "'" + " does not match the expected module name '" + moduleName + "'.");
	// }

	@Override
	public List<String> processBaseDecl(IStrategoTerm toplevelDecl) throws IOException {
		// if (getLanguage().isNamespaceDec(toplevelDecl)) {
		// processNamespaceDecl(toplevelDecl);
		// return Collections.emptyList();
		// }
		//
		// IStrategoTerm term = getApplicationSubterm(toplevelDecl, "CBody", 0);
		// String text = null;
		// try {
		// text = prettyPrint(term);
		// } catch (NullPointerException e) {
		// ATermCommands.setErrorMessage(toplevelDecl, "pretty printing C failed");
		// }
		// if (text != null)
		// body.add(text);

		System.out.println("################ " + toplevelDecl);

		System.out.println("##$$##$$##$$##$$ " + prettyPrint(toplevelDecl));

		body.add(prettyPrint(toplevelDecl));

		return Collections.emptyList();
	}

	@Override
	public String getModulePathOfImport(IStrategoTerm toplevelDecl) {
		return prettyPrint(getApplicationSubterm(toplevelDecl, "Import", 2)).replace('.', '/'); // TODO: ???
	}

	@Override
	public void processModuleImport(IStrategoTerm toplevelDecl) throws IOException {
		imports.add(prettyPrint(toplevelDecl));
	}

	@Override
	public String getExtensionName(IStrategoTerm decl) throws IOException {
		// hasExtension = true;
		return moduleName;
	}

	private String prettyPrint(IStrategoTerm term) {
		if (ppTable == null)
			ppTable = ATermCommands.readPrettyPrintTable(getLanguage().ensureFile("org/sugarj/languages/C.pp").getAbsolutePath());

		return ATermCommands.prettyPrint(ppTable, term, interp);
	}

	@Override
	public List<Path> compile(List<Path> outFiles, Path bin, List<Path> includePaths) throws IOException {
		List<String> cmds = new LinkedList<String>();
		// cmds.add("gcc");
		cmds.add("C:\\Cygwin\\bin\\gcc");

		String exeOutFile = FileCommands.dropExtension(outCFile.getAbsolutePath()) + ".exe";

		// cmds.add("-o " + exeOutFile);
		System.out.println("%%%%%%%%%%%%%%%%%% sourceFile " + sourceFile);

		System.out.println("%%%%%%%%%%%%%%%%%% outFile " + outCFile);
		System.out.println("%%%%%%%%%%%%%%%%%% bin " + bin);
		System.out.println("%%%%%%%%%%%%%%%%%% outFiles " + outFiles);

		System.out.println("%%%%%%%%%%%%%%%%%% includePaths " + includePaths);
		List<Path> generatedFiles = new LinkedList<Path>();

		for (Path path : includePaths) {
			if (new File(path.getAbsolutePath()).isDirectory()) {
				// cmds.add("-I \"" + path + "\"");
				//cmds.add("-I \"" + path.getAbsolutePath() + "\"");
				
				cmds.add("\"-I " + path + "\"");
			}
		}

		for (Path path : outFiles)
			cmds.add(path.toString());

		System.out.println("%%%%%%%%%%%%%%%%%% cmds " + cmds);

		new CommandExecution(false).execute(cmds.toArray(new String[cmds.size()]));
		


		if (new File(exeOutFile).exists())
			generatedFiles.add(new AbsolutePath(exeOutFile));
		else
			System.err.println("$$$$$$$$$$$$$$$$$$$$$$$ nichts erzeugt? existiert nicht:" + exeOutFile);

		return generatedFiles;
	}

	@Override
	public boolean isModuleExternallyResolvable(String relModulePath) {
		return false;
	}

	@Override
	public IStrategoTerm getExtensionBody(IStrategoTerm decl) {
		return getApplicationSubterm(decl, "ExtensionBody", 0);
	}
}

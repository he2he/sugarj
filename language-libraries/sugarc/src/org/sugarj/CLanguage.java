package org.sugarj;

import static org.sugarj.common.ATermCommands.isApplication;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.sugarj.common.path.Path;

/**
 * @author Matthias Becker
 */

public class CLanguage extends AbstractBaseLanguage {

	private CLanguage() { }
	
	private static CLanguage instance = new CLanguage();
	
	public static CLanguage getInstance() {
		return instance;
	}
	
	/**
	 * @see org.sugarj.AbstractBaseLanguage#createNewProcessor()
	 */
	@Override
	public AbstractBaseProcessor createNewProcessor() {
		return new CProcessor();
	}

  @Override
  public String getVersion() {
    return "c-0.1";
  }
  
  @Override
  public String getLanguageName() {
    return "C";
  }

  @Override
  public String getBinaryFileExtension() {
    return "o";
  }

  @Override
  public String getSugarFileExtension() {
    return "sugc";
  }
  
  @Override
  public String getBaseFileExtension() {
    return "c";
  }

  @Override
  public List<Path> getPackagedGrammars() {
    List<Path> grammars = new LinkedList<Path>(super.getPackagedGrammars());
    grammars.add(ensureFile("org/sugarj/languages/SugarC.def"));
    grammars.add(ensureFile("org/sugarj/languages/C.def"));
    return Collections.unmodifiableList(grammars);
  }

  @Override
  public Path getInitEditor() {
    return ensureFile("org/sugarj/c/initEditor.serv");
  }

  @Override
  public String getInitEditorModuleName() {
    return "org/sugarj/c/initEditor";
  }

  @Override
  public Path getInitGrammar() {
    return ensureFile("org/sugarj/c/initGrammar.sdf");
  }

  @Override
  public String getInitGrammarModuleName() {
    return "org/sugarj/c/initGrammar";
  }

  @Override
  public Path getInitTrans() {
    return ensureFile("org/sugarj/c/initTrans.str");
  }

  @Override
  public String getInitTransModuleName() {
    return "org/sugarj/c/initTrans";
  }

  @Override
  public boolean isExtensionDecl(IStrategoTerm decl) {
    if (isApplication(decl, "ExtensionBody"))
      return true;
    return false;
  }

  @Override
  public boolean isImportDecl(IStrategoTerm decl) {
    return isApplication(decl, "Import");   // TODO: wie soll es heiﬂen?
  }

  @Override
  public boolean isBaseDecl(IStrategoTerm decl) {
    return isApplication(decl, "TranslationUnit");
  }

  // TODO: Es gibt keine 
  public boolean isNamespaceDec(IStrategoTerm decl) {
    return false; //return isApplication(decl, "ModuleDec");
  }

  // TODO: ???
  @Override
  public boolean isPlainDecl(IStrategoTerm decl) {
//    if (isApplication(decl, "PlainDec"))
//      return true;
	  System.out.println("&&&&&&&&&&&&&&&&&& is plain decl " + decl);
    return false;
  }

}

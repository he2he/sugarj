package org.sugarj;

/**
 * @author Sebastian Erdweg <seba at informatik uni-marburg de>
 */

public class CLibFactory extends LanguageLibFactory {

	private CLibFactory() { }
	
	private static CLibFactory instance = new CLibFactory();
	
	public static CLibFactory getInstance() {
		return instance;
	}
	
	/**
	 * @see org.sugarj.LanguageLibFactory#createLanguageLibrary()
	 */
	@Override
	public LanguageLib createLanguageLibrary() {
		return new CLib();
	}

  @Override
  public String getVersion() {
    return "haskell-0.1a";
  }
  
  @Override
  public String getLanguageName() {
    return "Haskell";
  }

  @Override
  public String getGeneratedFileExtension() {
    return "o";
  }

  @Override
  public String getSugarFileExtension() {
    return "shs";
  }
  
  @Override
  public String getOriginalFileExtension() {
    return "hs";
  }

}

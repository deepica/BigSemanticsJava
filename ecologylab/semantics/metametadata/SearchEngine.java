/**
 * 
 */
package ecologylab.semantics.metametadata;

import ecologylab.net.ParsedURL;
import ecologylab.xml.ElementState;
import ecologylab.xml.types.element.Mappable;

/**
 * @author amathur
 *
 */
public class SearchEngine extends ElementState implements Mappable<String>
{

	@xml_attribute private String name;
	
	@xml_attribute private String urlPrefix;
	
	@xml_attribute private String urlSuffix;
	
	public SearchEngine() {}

	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public final String getUrlPrefix()
	{
		return urlPrefix;
	}

	/**
	 * @param url the url to set
	 */
	public final void setUrlPrefix(String urlPrefix)
	{
		this.urlPrefix = urlPrefix;
	}

	@Override
	public String key()
	{
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * @return the urlSuffix
	 */
	public final String getUrlSuffix()
	{
		return urlSuffix;
	}

	/**
	 * @param urlSuffix the urlSuffix to set
	 */
	public final void setUrlSuffix(String urlSuffix)
	{
		this.urlSuffix = urlSuffix;
	}
	
}

package ecologylab.media.html.dom;

import java.util.HashMap;

import org.w3c.tidy.AttVal;
import org.w3c.tidy.TdNode;

import ecologylab.generic.Generic;

/**
 * data structure that contains the DOM node for the {@link ImgElement} and it's associate attributes. 
 * 
 * @author eunyee
 *
 */    
public class HTMLElement
{
	private TdNode node;
	private HashMap<String, String> attributesMap;
	
	
	public HTMLElement(TdNode node)
	{
		this.node						= node;
		addAttributes(node.attributes);
	}
	
	public void setAttribute(String key, String value)
	{
		if (attributesMap == null)
			attributesMap	= new HashMap<String, String>();
		
		attributesMap.put(key, value);
	}
	
	public void clearAttribute(String key)
	{
		if (attributesMap != null)
			attributesMap.put(key, null);
	}
	
	public String getAttribute(String key)
	{
		return attributesMap == null ? null : attributesMap.get(key);
	}
	
	public int getAttributeAsInt(String key)
	{
		String value	= getAttribute(key);
		return value == null ? -1 : Generic.parseInt(value, -1 );
	}
	public int getAttributeAsInt(String key, int defaultValue)
	{
		String value	= getAttribute(key);
		return value == null ? -1 : Generic.parseInt(value, defaultValue);
	}
	
	public boolean getAttributeAsBoolean(String key)
	{
		String value	= getAttribute(key);
		return value != null && "true".equals(value);
	}
	
	public void setNode(TdNode node) 
	{
		this.node = node;
	}
	
	public TdNode getNode() 
	{
		return node;
	}
	
	/**
	 * Create HashMap of attributes from tidy AttVal linked list of them.
	 */
	private void addAttributes(AttVal attr)
	{
		if (attr != null)
		{
			setAttribute(attr.attribute, attr.value);
			if (attr.next != null)
				addAttributes(attr.next);
		}
	}

	public void recycle()
	{
		if (attributesMap != null)
		{
			attributesMap.clear();
			attributesMap	= null;
		}
		node.recycle();
		node					= null;
	}
	
}
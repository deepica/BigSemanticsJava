/**
 * 
 */
package ecologylab.bigsemantics.metametadata;

import java.util.Iterator;

import ecologylab.bigsemantics.metadata.Metadata;
import ecologylab.generic.OneLevelNestingIterator;

/**
 * @author andrew
 *
 */
public class MetaMetadataOneLevelNestingIterator extends OneLevelNestingIterator<MetaMetadataField, MetaMetadataField>
{

	private Iterator<Metadata> nextMetadatas 	= null;
	
	private Metadata currentMetadata 					= null;
	
	
	public MetaMetadataOneLevelNestingIterator(MetaMetadataField firstObject, Metadata firstMetadata)
	{
		super(firstObject);
		
		currentMetadata = firstMetadata;
	}

	@Override
	public MetaMetadataField next() 
	{
		boolean newMetadata = (currentIterator == null && !firstIterator.hasNext()) || 
			(currentIterator != null && !currentIterator.hasNext()); // && (currentIterator == firstIterator ) || ();
		if (newMetadata)
			currentMetadata = nextMetadatas.next();
		
		MetaMetadataField result = super.next();
		
		return result;
	}
	
	public Metadata currentMetadata()
	{
		return currentMetadata;
	}
}

/**
 * 
 */
package ecologylab.semantics.metametadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ecologylab.generic.OneLevelNestingIterator;
import ecologylab.semantics.metadata.Metadata;

/**
 * @author andrew
 *
 */
public class MetaMetadataOneLevelNestingIterator extends OneLevelNestingIterator<MetaMetadataField, MetaMetadataField>
{

	private Iterator<Metadata> nextMetadatas 	= null;
	
	private Metadata currentMetadata 					= null;
	
	
	public MetaMetadataOneLevelNestingIterator(MetaMetadataField firstObject, Metadata firstMetadata, ArrayList<Metadata> mixinMetadatas)
	{
		super(firstObject, createMixinCollectionIterator(mixinMetadatas));
		
		currentMetadata = firstMetadata;
		if (mixinMetadatas != null)
			nextMetadatas = mixinMetadatas.iterator();
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
	
	private static Iterator<? extends MetaMetadataField> createMixinCollectionIterator(ArrayList<Metadata> mixinMetadatas)
	{
		ArrayList<MetaMetadata> mixinMetaMetadatas = null;
		if (mixinMetadatas != null)
		{
			mixinMetaMetadatas = new ArrayList<MetaMetadata>();
			for (Metadata metadata : mixinMetadatas)
				mixinMetaMetadatas.add(metadata.getMetaMetadata());
			
			return mixinMetaMetadatas.iterator();
		}
		else
			return null;
		
	}

}
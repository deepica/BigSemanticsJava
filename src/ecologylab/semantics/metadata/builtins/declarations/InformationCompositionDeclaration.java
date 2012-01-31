package ecologylab.semantics.metadata.builtins.declarations;

/**
 * Automatically generated by MetaMetadataJavaTranslator
 *
 * DO NOT modify this code manually: All your changes may get lost!
 *
 * Copyright (2012) Interface Ecology Lab.
 */

import ecologylab.semantics.metadata.Metadata;
import ecologylab.semantics.metadata.builtins.Annotation;
import ecologylab.semantics.metadata.builtins.Clipping;
import ecologylab.semantics.metadata.builtins.Document;
import ecologylab.semantics.metadata.builtins.MetadataBuiltinsTranslationScope;
import ecologylab.semantics.metadata.mm_name;
import ecologylab.semantics.metadata.scalar.MetadataFloat;
import ecologylab.semantics.metametadata.MetaMetadataCompositeField;
import ecologylab.semantics.namesandnums.SemanticsNames;
import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.annotations.simpl_scope;
import java.lang.Float;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@simpl_inherit
public abstract class InformationCompositionDeclaration extends Document
{
	@simpl_collection
	@simpl_scope("repository_clippings")
	@mm_name("clippings")
	private List<Clipping> clippings;

	@simpl_collection("annotation")
	@mm_name("annotations")
	private List<Annotation> annotations;

	@simpl_collection
	@simpl_scope("repository_media")
	@mm_name("media")
	private List<Metadata> media;

	@simpl_scalar
	private MetadataFloat version;

	@simpl_scalar
	private MetadataFloat metadataVersion;

	public InformationCompositionDeclaration()
	{ super(); }

	public InformationCompositionDeclaration(MetaMetadataCompositeField mmd) {
		super(mmd);
	}


	public List<Clipping> getClippings()
	{
		return clippings;
	}

	public void setClippings(List<Clipping> clippings)
	{
		this.clippings = clippings;
	}

	public List<Annotation> getAnnotations()
	{
		return annotations;
	}

	public void setAnnotations(List<Annotation> annotations)
	{
		this.annotations = annotations;
	}

	public List<Metadata> getMedia()
	{
		return media;
	}

	public void setMedia(List<Metadata> media)
	{
		this.media = media;
	}

	public MetadataFloat	version()
	{
		MetadataFloat	result = this.version;
		if (result == null)
		{
			result = new MetadataFloat();
			this.version = result;
		}
		return result;
	}

	public Float getVersion()
	{
		return this.version == null ? 0 : version().getValue();
	}

	public MetadataFloat getVersionMetadata()
	{
		return version;
	}

	public void setVersion(Float version)
	{
		if (version != 0)
			this.version().setValue(version);
	}

	public void setVersionMetadata(MetadataFloat version)
	{
		this.version = version;
	}

	public MetadataFloat	metadataVersion()
	{
		MetadataFloat	result = this.metadataVersion;
		if (result == null)
		{
			result = new MetadataFloat();
			this.metadataVersion = result;
		}
		return result;
	}

	public Float getMetadataVersion()
	{
		return this.metadataVersion == null ? 0 : metadataVersion().getValue();
	}

	public MetadataFloat getMetadataVersionMetadata()
	{
		return metadataVersion;
	}

	public void setMetadataVersion(Float metadataVersion)
	{
		if (metadataVersion != 0)
			this.metadataVersion().setValue(metadataVersion);
	}

	public void setMetadataVersionMetadata(MetadataFloat metadataVersion)
	{
		this.metadataVersion = metadataVersion;
	}
}

package ecologylab.semantics.model.text;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import java.util.Observer;

import ecologylab.generic.IFeatureVector;
/**
 * A CompositeTermVector acts like a TermVector on the outside, but on the inside
 * it maintains a reference to each TermVector added to it.  This means that if the content
 * of a TermVector is modified, this modification bubbles up through the CompositeTermVector
 * which is observing all it's component term vectors.
 * @author jmole
 *
 */
public class CompositeTermVector extends Observable implements Observer, ITermVector
{

	public CompositeTermVector ()
	{
	}

	private TermVector						compositeTermVector	= new TermVector();

	private HashMap<ITermVector, Double>	termVectors			= new HashMap<ITermVector, Double>();

	/**
	 * Adds a Term Vector to this Composite Term Vectors collection, multiplying it by a scalar.
	 * 
	 * @param tv
	 *            The Term Vector you wish to add.
	 * @param multiplier
	 *            The scalar multiple.
	 */
	public void add ( double multiplier, ITermVector tv )
	{
		HashMap<ITermVector, Double> v;
		v = termVectors;
		synchronized (v)
		{
			double oldMultiplier = 0;
			if (v.containsKey(tv))
				oldMultiplier = v.get(tv);
			else
				tv.addObserver(this);
			v.put(tv, oldMultiplier + multiplier);
			compositeTermVector.add(multiplier, tv);
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Adds a Term Vector to this Composite Term Vector's collection
	 * 
	 * @param tv
	 *            The term vector you wish to add.
	 */
	public void add ( ITermVector tv )
	{
		if (tv != null)
			add(1, tv);
	}

	/**
	 * Removes a Term Vector from this Composite Term Vectors collection.
	 * 
	 * @param tv
	 *            The Term Vector you wish to remove.
	 */
	public void remove ( ITermVector tv )
	{
		Double removal = null;
		synchronized (termVectors)
		{
			removal = termVectors.remove(tv);
		}
		if (removal != null)
		{
			tv.deleteObserver(this);
			compositeTermVector.add(-removal, tv);
			setChanged();
			notifyObservers();
		}
	}

	public void update ( Observable o, Object arg )
	{
		rebuildCompositeTermVector();
		setChanged();
		notifyObservers();
	}

	public void recycle ( )
	{
		if (termVectors != null)
			for (ITermVector tv : termVectors.keySet())
				tv.deleteObserver(this);
	}

	private void rebuildCompositeTermVector ( )
	{
		TermVector c = new TermVector(compositeTermVector.size());
		synchronized (termVectors)
		{
			for (IFeatureVector<Term> t : termVectors.keySet())
				c.add(termVectors.get(t), t);
		}
		compositeTermVector = c;
	}

	public double dot ( IFeatureVector<Term> v )
	{
		return compositeTermVector.dot(v);
	}

	public Set<Term> elements ( )
	{
		return compositeTermVector.elements();
	}

	public double get ( Term term )
	{
		return compositeTermVector.get(term);
	}

	public HashMap<Term, Double> map ( )
	{
		return compositeTermVector.map();
	}

	public Set<Double> values ( )
	{
		return compositeTermVector.values();
	}

	public Set<ITermVector> componentVectors ( )
	{
		return termVectors.keySet();
	}

	public String toString ( )
	{
		StringBuilder s = new StringBuilder("[");
		synchronized (termVectors)
		{
			for (IFeatureVector<Term> v : termVectors.keySet())
			{
				s.append(v.toString());
				s.append(", ");
			}
		}
		s.append("]");
		return s.toString();
	}

	public double norm ( )
	{
		return compositeTermVector.norm();
	}

	public double max ( )
	{
		return compositeTermVector.max();
	}

	public double idfDot ( IFeatureVector<Term> v )
	{
		return compositeTermVector.idfDot(v);
	}

	public TermVector unit ( )
	{
		return compositeTermVector.unit();
	}

	public int commonDimensions ( IFeatureVector<Term> v )
	{
		return compositeTermVector.commonDimensions(v);
	}

	public double dotSimplex ( IFeatureVector<Term> v )
	{
		return compositeTermVector.dotSimplex(v);
	}

	public TermVector simplex ( )
	{
		return compositeTermVector.simplex();
	}

	public double idfDotSimplex ( IFeatureVector<Term> v )
	{
		return compositeTermVector.idfDotSimplex(v);
	}

}
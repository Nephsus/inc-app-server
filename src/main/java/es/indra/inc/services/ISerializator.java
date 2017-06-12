package es.indra.inc.services;



public interface ISerializator<T,K,F> {
	
	
    public T serialize( K inputObject);
	public F deserializer( T inputObject);

	

}

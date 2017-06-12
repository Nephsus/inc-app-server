package es.indra.inc.serializator;



public interface Serializator<T,K,F> {

    public T serialize( K inputObject);
	public F deserializer( T inputObject);


}

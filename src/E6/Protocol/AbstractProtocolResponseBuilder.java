package E6.Protocol;

public abstract class AbstractProtocolResponseBuilder {
    protected ProtocolResponse protocolResponse = new ProtocolResponse();
    protected String response;
    public AbstractProtocolResponseBuilder addResponse(String response){
        this.response=response;
        return this;
    }
    public abstract ProtocolResponse build();
}

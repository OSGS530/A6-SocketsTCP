package E6.Protocol;

import java.util.List;

public abstract class AbstractProtocolRequestBuilder {
    ProtocolRequest _request;
    List<Double> params;

    public abstract AbstractProtocolRequestBuilder setOperation(Integer operation);

    public abstract AbstractProtocolRequestBuilder addParam(Double params);

    public abstract ProtocolRequest build();
}

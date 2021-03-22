package E6.Protocol;

import java.util.ArrayList;
import java.util.List;

public class ProtocolRequestBuilder extends  AbstractProtocolRequestBuilder{


    public ProtocolRequestBuilder() {
        params = new ArrayList<>();
        this._request = new ProtocolRequest();
    }


    public ProtocolRequestBuilder setOperation(Integer operation) {
        this._request.setOperationType(operation);
        return this;
    }


    public ProtocolRequestBuilder addParam(Double params) {
        this.params.add(params);
        return this;
    }

    @Override
    public ProtocolRequest build() {
        this._request.setParams(params);
        return _request;
    }

}
package E6.Protocol;

public class ProtocolResponseBuilder extends AbstractProtocolResponseBuilder{
    @Override
    public ProtocolResponse build() {
        String[] res = super.response.split(",");
        System.out.println(res.length);
        protocolResponse.setOperacion(Integer.parseInt(res[0]));
        protocolResponse.setResultado(Double.parseDouble(res[1]));
        return protocolResponse;
    }
}

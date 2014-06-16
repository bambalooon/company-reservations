package pl.bb.broker.company.companyreserv.ws.messages;

import org.hibernate.HibernateException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 31.05.14
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
public class ReservationResponse {
    public enum ResponseType { ACCEPTED, REJECTED };
    private ResponseType responseType;
    private ReservationRequest request;

    @XmlAttribute
    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    @XmlElement
    public ReservationRequest getRequest() {
        return request;
    }

    public void setRequest(ReservationRequest request) {
        this.request = request;
    }
}

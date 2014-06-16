package pl.bb.broker.company.companyreserv.ws.services;

import pl.bb.broker.company.companyreserv.ws.exceptions.WSException;
import pl.bb.broker.company.companyreserv.ws.messages.ReservationRequest;
import pl.bb.broker.company.companyreserv.ws.messages.ReservationResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 31.05.14
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */

@WebService(name = "ReservationService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface ReservationService {

    @WebMethod
    ReservationResponse makeReservation(@WebParam(name = "request") ReservationRequest request) throws WSException;

}

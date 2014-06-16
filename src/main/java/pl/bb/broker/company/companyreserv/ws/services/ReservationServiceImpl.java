package pl.bb.broker.company.companyreserv.ws.services;

import org.hibernate.HibernateException;
import pl.bb.broker.company.companydb.pensjonat.entities.FacilitiesEntity;
import pl.bb.broker.company.companydb.pensjonat.entities.ReservationsEntity;
import pl.bb.broker.company.companydb.pensjonat.entities.RoomsEntity;
import pl.bb.broker.company.companydb.pensjonat.entities.UsersEntity;
import pl.bb.broker.company.companydb.util.PensjonatDBReservationsUtil;
import pl.bb.broker.company.companyreserv.ws.exceptions.WSException;
import pl.bb.broker.company.companyreserv.ws.exceptions.WSExceptionBean;
import pl.bb.broker.company.companyreserv.ws.messages.ReservationRequest;
import pl.bb.broker.company.companyreserv.ws.messages.ReservationResponse;

import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 31.05.14
 * Time: 22:57
 * To change this template use File | Settings | File Templates.
 */

@WebService(endpointInterface = "pl.bb.broker.company.companyreserv.ws.services.ReservationService")
public class ReservationServiceImpl implements ReservationService {

    @Override
    public ReservationResponse makeReservation(ReservationRequest request) throws WSException{
        ReservationResponse response = new ReservationResponse();
        UsersEntity user = new UsersEntity();
        user.setUsername(request.getUsername());
        user.setFirstname(request.getFirstname());
        user.setSurname(request.getSurname());

        FacilitiesEntity facility = new FacilitiesEntity();
        facility.setName(request.getFacility());

        RoomsEntity room = new RoomsEntity();
        room.setRtype(request.getRoomType());
        room.setFacility(facility);

        ReservationsEntity reservation = new ReservationsEntity();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setArrival(request.getArrival());
        reservation.setDeparture(request.getDeparture());

        try {
            boolean reserved = PensjonatDBReservationsUtil.FACTORY.tryToReserve(reservation);
            if(reserved) {
                response.setResponseType(ReservationResponse.ResponseType.ACCEPTED);
                response.setRequest(request);
            }
            else {
                response.setResponseType(ReservationResponse.ResponseType.REJECTED);
                response.setRequest(request);
            }
        } catch (HibernateException e) {
            throw new WSException(e.getMessage(), new WSExceptionBean(e.getMessage()), e);
        }
        return response;
    }
}

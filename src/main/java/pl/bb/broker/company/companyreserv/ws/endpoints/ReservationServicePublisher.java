package pl.bb.broker.company.companyreserv.ws.endpoints;

import pl.bb.broker.company.companyreserv.ws.services.ReservationServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 01.06.14
 * Time: 01:02
 * To change this template use File | Settings | File Templates.
 */
public class ReservationServicePublisher {

    public static void publish(String address) {
        Endpoint.publish(address, new ReservationServiceImpl());
    }
}

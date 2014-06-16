package pl.bb.broker.company.companyreserv.ws.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BamBalooon
 * Date: 31.05.14
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class DateAdapter extends XmlAdapter<Long, Date> {
    public Date unmarshal(Long date) {
        return new Date(date);
    }

    public Long marshal(Date date) {
        return date.getTime();
    }
}

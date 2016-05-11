package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.List;



/**
 * Created by jhj on 2016-05-11.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}

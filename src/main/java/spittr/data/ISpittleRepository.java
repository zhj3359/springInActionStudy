package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jhj on 2016-05-11.
 */
@Repository
public class ISpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for(int i = 0; i<count; i++){
            spittles.add(new Spittle("Spittle" + i ,new Date()));
        }
        return  spittles;
    }
}

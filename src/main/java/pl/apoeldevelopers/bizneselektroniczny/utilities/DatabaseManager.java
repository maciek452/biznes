package pl.apoeldevelopers.bizneselektroniczny.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.apoeldevelopers.bizneselektroniczny.database.repositories.MapRepo;
import pl.apoeldevelopers.bizneselektroniczny.database.repositories.RatingRepo;
import pl.apoeldevelopers.bizneselektroniczny.entities.RatingInput;
import pl.apoeldevelopers.bizneselektroniczny.entities.RecoList;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserIdMap;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserRating;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
@Service
public class DatabaseManager {
    @Autowired
    RatingRepo ratingRepo;

    @Autowired
    MapRepo mapRepo;

    public void addUserRating(RatingInput ratingInput){
        UserIdMap userIdMap = new UserIdMap(ratingInput.getUserId());
        mapRepo.save(userIdMap);
        UserRating userRating = new UserRating(userIdMap.getLid(), ratingInput.getProductId(), ratingInput.getRating());
        ratingRepo.save(userRating);
    }
}

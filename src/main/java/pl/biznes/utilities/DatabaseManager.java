package pl.biznes.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biznes.database.repositories.*;
import pl.biznes.entities.RatingInput;
import pl.biznes.entities.UserIdMap;
import pl.biznes.entities.UserRating;

import java.util.List;

@Service
public class DatabaseManager {
    @Autowired
    RatingRepo ratingRepo;
    @Autowired
    MapRepo mapRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductLangRepo productLangRepo;
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    CategoryLangRepo categoryLangRepo;
    @Autowired
    CategoryProductRepo categoryProductRepo;

    public void addUserRating(RatingInput ratingInput){
        List<UserIdMap> list =  mapRepo.findFirstBySid(ratingInput.getUserId());
        UserIdMap userIdMap;
        if(list.size() > 0)
            userIdMap = list.get(0);
        else{
            userIdMap = new UserIdMap(ratingInput.getUserId());
            mapRepo.save(userIdMap);
        }
        List<UserRating> ratingList  = ratingRepo.findFirstByProductIdAndUserId(ratingInput.getProductId(), userIdMap.getLid());

        if(ratingList.size() > 0){
            UserRating userRating = ratingList.get(0);
            if(ratingInput.getRating() > userRating.getRating()){
                UserRating newRating = new UserRating(userIdMap.getLid(), ratingInput.getProductId(), ratingInput.getRating());
                ratingRepo.save(newRating);
            }
        }else {
            UserRating userRating = new UserRating(userIdMap.getLid(), ratingInput.getProductId(), ratingInput.getRating());
            ratingRepo.save(userRating);
        }
    }

}

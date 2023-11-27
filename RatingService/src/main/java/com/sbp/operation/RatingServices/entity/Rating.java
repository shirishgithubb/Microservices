package com.sbp.operation.RatingServices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("rating")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}

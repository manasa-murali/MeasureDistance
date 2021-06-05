package com.example.measuredistance.viewmodel

import com.example.measuredistance.model.CustomerData
import com.example.measuredistance.utils.FilteredData

val dummyData =
            "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}\n" +
            "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}\n" +
            "{\"latitude\": \"51.8856167\", \"user_id\": 2, \"name\": \"Ian McArdle\", \"longitude\": \"-10.4240951\"}\n" +
            "{\"latitude\": \"52.3191841\", \"user_id\": 3, \"name\": \"Jack Enright\", \"longitude\": \"-8.5072391\"}\n" +
            "{\"latitude\": \"53.807778\", \"user_id\": 28, \"name\": \"Charlie Halligan\", \"longitude\": \"-7.714444\"}\n" +
            "{\"latitude\": \"53.4692815\", \"user_id\": 7, \"name\": \"Frank Kehoe\", \"longitude\": \"-9.436036\"}\n" +
            "{\"latitude\": \"54.0894797\", \"user_id\": 8, \"name\": \"Eoin Ahearn\", \"longitude\": \"-6.18671\"}\n" +
            "{\"latitude\": \"53.038056\", \"user_id\": 26, \"name\": \"Stephen McArdle\", \"longitude\": \"-7.653889\"}\n" +
            "{\"latitude\": \"54.1225\", \"user_id\": 27, \"name\": \"Enid Gallagher\", \"longitude\": \"-8.143333\"}\n" +
            "{\"latitude\": \"53.1229599\", \"user_id\": 6, \"name\": \"Theresa Enright\", \"longitude\": \"-6.2705202\"}\n" +
            "{\"latitude\": \"52.2559432\", \"user_id\": 9, \"name\": \"Jack Dempsey\", \"longitude\": \"-7.1048927\"}\n" +
            "{\"latitude\": \"52.240382\", \"user_id\": 10, \"name\": \"Georgina Gallagher\", \"longitude\": \"-6.972413\"}\n" +
            "{\"latitude\": \"53.2451022\", \"user_id\": 4, \"name\": \"Ian Kehoe\", \"longitude\": \"-6.238335\"}\n" +
            "{\"latitude\": \"53.1302756\", \"user_id\": 5, \"name\": \"Nora Dempsey\", \"longitude\": \"-6.2397222\"}\n" +
            "{\"latitude\": \"53.008769\", \"user_id\": 11, \"name\": \"Richard Finnegan\", \"longitude\": \"-6.1056711\"}\n" +
            "{\"latitude\": \"53.1489345\", \"user_id\": 31, \"name\": \"Alan Behan\", \"longitude\": \"-6.8422408\"}\n" +
            "{\"latitude\": \"53\", \"user_id\": 13, \"name\": \"Olive Ahearn\", \"longitude\": \"-7\"}\n" +
            "{\"latitude\": \"51.999447\", \"user_id\": 14, \"name\": \"Helen Cahill\", \"longitude\": \"-9.742744\"}\n" +
            "{\"latitude\": \"52.966\", \"user_id\": 15, \"name\": \"Michael Ahearn\", \"longitude\": \"-6.463\"}\n" +
            "{\"latitude\": \"52.366037\", \"user_id\": 16, \"name\": \"Ian Larkin\", \"longitude\": \"-8.179118\"}\n" +
            "{\"latitude\": \"54.180238\", \"user_id\": 17, \"name\": \"Patricia Cahill\", \"longitude\": \"-5.920898\"}\n" +
            "{\"latitude\": \"53.0033946\", \"user_id\": 39, \"name\": \"Lisa Ahearn\", \"longitude\": \"-6.3877505\"}\n" +
            "{\"latitude\": \"52.228056\", \"user_id\": 18, \"name\": \"Bob Larkin\", \"longitude\": \"-7.915833\"}\n" +
            "{\"latitude\": \"54.133333\", \"user_id\": 24, \"name\": \"Rose Enright\", \"longitude\": \"-6.433333\"}\n" +
            "{\"latitude\": \"55.033\", \"user_id\": 19, \"name\": \"Enid Cahill\", \"longitude\": \"-8.112\"}\n" +
            "{\"latitude\": \"53.521111\", \"user_id\": 20, \"name\": \"Enid Enright\", \"longitude\": \"-9.831111\"}\n" +
            "{\"latitude\": \"51.802\", \"user_id\": 21, \"name\": \"David Ahearn\", \"longitude\": \"-9.442\"}\n" +
            "{\"latitude\": \"54.374208\", \"user_id\": 22, \"name\": \"Charlie McArdle\", \"longitude\": \"-8.371639\"}\n" +
            "{\"latitude\": \"53.74452\", \"user_id\": 29, \"name\": \"Oliver Ahearn\", \"longitude\": \"-7.11167\"}\n" +
            "{\"latitude\": \"53.761389\", \"user_id\": 30, \"name\": \"Nick Enright\", \"longitude\": \"-7.2875\"}\n" +
            "{\"latitude\": \"54.080556\", \"user_id\": 23, \"name\": \"Eoin Gallagher\", \"longitude\": \"-6.361944\"}\n" +
            "{\"latitude\": \"52.833502\", \"user_id\": 25, \"name\": \"David Behan\", \"longitude\": \"-8.522366\"}"


val customerDataList : List<CustomerData> = listOf(
    CustomerData(latitude = 52.986375, userID=12, userName ="Christina McArdle", longitude = -6.043701),
         CustomerData( latitude = 51.92893, userID=1,  userName ="Alice Cahill", longitude =-10.27699 ),
         CustomerData( latitude = 51.8856167, userID=2,  userName ="Ian McArdle", longitude =-10.4240951),
         CustomerData( latitude = 52.3191841, userID=3,  userName ="Jack Enright", longitude =-8.5072391),
         CustomerData( latitude = 53.807778, userID=28,  userName ="Charlie Halligan", longitude =-7.714444),
         CustomerData( latitude = 53.4692815, userID=7,  userName ="Frank Kehoe", longitude =-9.436036),
         CustomerData( latitude = 54.0894797, userID=8,  userName ="Eoin Ahearn", longitude =-6.18671),
         CustomerData( latitude = 53.038056, userID=26,  userName ="Stephen McArdle", longitude =-7.653889),
         CustomerData( latitude = 54.1225, userID=27,  userName ="Enid Gallagher", longitude =-8.143333),
         CustomerData( latitude = 53.1229599, userID=6,  userName ="Theresa Enright", longitude =-6.2705202),
         CustomerData( latitude = 52.2559432, userID=9,  userName ="Jack Dempsey", longitude =-7.1048927),
         CustomerData( latitude = 52.240382, userID=10,  userName ="Georgina Gallagher", longitude =-6.972413),
         CustomerData( latitude = 53.2451022, userID=4,  userName ="Ian Kehoe", longitude =-6.238335),
         CustomerData( latitude = 53.1302756, userID=5,  userName ="Nora Dempsey", longitude =-6.2397222),
         CustomerData( latitude = 53.008769, userID=11,  userName ="Richard Finnegan", longitude =-6.1056711),
         CustomerData( latitude = 53.1489345, userID=31,  userName ="Alan Behan", longitude =-6.8422408),
         CustomerData( latitude = 53.0, userID=13,  userName ="Olive Ahearn", longitude =-7.0),
         CustomerData( latitude = 51.999447, userID=14,  userName ="Helen Cahill", longitude =-9.742744),
         CustomerData( latitude = 52.966, userID=15,  userName ="Michael Ahearn", longitude =-6.463),
         CustomerData( latitude = 52.366037, userID=16,  userName ="Ian Larkin", longitude =-8.179118),
         CustomerData( latitude = 54.180238, userID=17,  userName ="Patricia Cahill", longitude =-5.920898),
         CustomerData( latitude = 53.0033946, userID=39,  userName ="Lisa Ahearn", longitude =-6.3877505),
         CustomerData( latitude = 52.228056, userID=18,  userName ="Bob Larkin", longitude =-7.915833),
         CustomerData( latitude = 54.133333, userID=24,  userName ="Rose Enright", longitude =-6.433333),
         CustomerData( latitude = 55.033, userID=19,  userName ="Enid Cahill", longitude =-8.112),
         CustomerData( latitude = 53.521111, userID=20,  userName ="Enid Enright", longitude =-9.831111),
         CustomerData( latitude = 51.802, userID=21,  userName ="David Ahearn", longitude =-9.442),
         CustomerData( latitude = 54.374208, userID=22,  userName ="Charlie McArdle", longitude =-8.371639),
         CustomerData( latitude = 53.74452, userID=29,  userName ="Oliver Ahearn", longitude =-7.11167),
         CustomerData( latitude = 53.761389, userID=30,  userName ="Nick Enright", longitude =-7.2875),
         CustomerData( latitude = 54.080556, userID=23,  userName ="Eoin Gallagher", longitude =-6.361944),
         CustomerData( latitude = 52.833502, userID=25,  userName ="David Behan", longitude =-8.522366)
)

val filteredData: List<FilteredData> = listOf(
     FilteredData(userID = 4, userName = "Ian Kehoe"),
     FilteredData(userID = 5, userName = "Nora Dempsey"),
     FilteredData(userID = 6, userName = "Theresa Enright"),
     FilteredData(userID = 8, userName = "Eoin Ahearn"),
     FilteredData(userID = 11, userName = "Richard Finnegan"),
     FilteredData(userID = 12, userName = "Christina McArdle"),
     FilteredData(userID = 13, userName = "Olive Ahearn"),
     FilteredData(userID = 15, userName = "Michael Ahearn"),
     FilteredData(userID = 17, userName = "Patricia Cahill"),
     FilteredData(userID = 23, userName = "Eoin Gallagher"),
     FilteredData(userID = 24, userName = "Rose Enright"),
     FilteredData(userID = 26, userName = "Stephen McArdle"),
     FilteredData(userID = 29, userName = "Oliver Ahearn"),
     FilteredData(userID = 30, userName = "Nick Enright"),
     FilteredData(userID = 31, userName = "Alan Behan"),
     FilteredData(userID = 39, userName = "Lisa Ahearn")
)


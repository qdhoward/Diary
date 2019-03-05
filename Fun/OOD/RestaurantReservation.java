package Fun.OOD;

public class RestaurantReservation {
    class User {
        long userId;
        String name;
        String phoneNumber;
    }

    class TimeSpan {
        long start;
        long end;
    }

    class RevervationRequest {
        TimeSpan interval;
        long userId;
        int numOfParties;
    }

    class ReservationConfirmation {
        long id;
        long tableId;
        RevervationRequest request;
        void sendNotification(){}
    }

    enum TableType {
        NearWindow("Window"),
        NearBar("Bar");

        private final String type;

        TableType(String type) {
            this.type = type;
        }
    }
//    class BaseTable {
//        TableType type;
//        long tableId;
//        int capacitu;
//        boolean isAvailableNow;
//
//    }

    interface BaseTable {
        
    }

    class TableWithBooster implements BaseTable {
        BaseTable table;
        int booster;
        public int getBooster(){
            return 0;
        }
        public void setBooster() {}
    }

    interface TableAvailablityAlgorithm {
        boolean isAvailable(RevervationRequest request, Map<Table, >);
        ReservationConfirmation getConfirmation()
    }
}

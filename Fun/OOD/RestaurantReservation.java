package Fun.OOD;

import java.util.List;
import java.util.Map;

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

    class ReservationRequest {
        TimeSpan interval;
        long userId;
        int numOfParties;
    }

    class ReservationConfirmation {
        long id;
        long tableId;
        ReservationRequest request;
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

    interface TableAvailabilityAlgorithm {
//        boolean isAvailable(ReservationRequest request, Map<BaseTable, List<ReservationConfirmation>> tables);
//        ReservationConfirmation getConfirmation(ReservationRequest, Map<BaseTable, List<ReservationConfirmation>> tables);
    }

    class CanMergeAlgorithm implements TableAvailabilityAlgorithm {

    }

    interface TableState {
        Map<BaseTable, List<ReservationConfirmation>> getMapView();
        List<BaseTable> getListView();
    }

    class TableAvailabilityManager {
        TableState tables;
        TableAvailabilityAlgorithm algorithm;
        public TableAvailabilityManager(TableAvailabilityAlgorithm algorithm) {

        }

        public void setAlgorithm(TableAvailabilityAlgorithm newAlgorithm) {

        }

        TableAvailabilityAlgorithm getAlgorithm() {
            return algorithm;
        }

        boolean isAvailable(ReservationRequest request) {
            return true;
        }
    }

    class NotificationManager extends Thread {
        @Override
        public void start() {

        }
    }

    class ReservationSystem {
        String restaurantName;
        String address;
        String phone;
        TableAvailabilityManager tableManager;
        NotificationManager notificationManager;

//        ReservationConfirmation makeReservation(ReservationRequest request) {
//
//        }
//
//        boolean checkAvailability(ReservationRequest request) {
//
//        }
    }

}

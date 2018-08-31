package com.chamika.fidenz.facilityconsole.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fidenz on 2/20/18.
 */

public class Booking {


    /**
     * Weather : weather_sunny
     * NewsTicker : {"Text":"   *   Rent-a-church spire plan to boost mobile phone coverage   *   Facebook told to stop tracking in Belgium   *   Anger at Google image search 'peace deal'   *   Hot on Instagram - but is it art?","FontColor":"#000000","BKColor":"#ffff00"}
     * Bookings : [{"BookingKey":"S879","StartTime":"2018-02-20T13:00:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"13:00","ActualStartTime":"2018-02-20T07:30:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:073000","EndTime":"20180220:080000","ScannerStatus":"0"},{"BookingKey":"S878","StartTime":"2018-02-20T13:30:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"13:30","ActualStartTime":"2018-02-20T08:00:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:080000","EndTime":"20180220:083000","ScannerStatus":"0"},{"BookingKey":"S877","StartTime":"2018-02-20T14:00:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"14:00","ActualStartTime":"2018-02-20T08:30:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:083000","EndTime":"20180220:090000","ScannerStatus":"0"},{"BookingKey":"S876","StartTime":"2018-02-20T14:30:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"14:30","ActualStartTime":"2018-02-20T09:00:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:090000","EndTime":"20180220:093000","ScannerStatus":"0"},{"BookingKey":"S875","StartTime":"2018-02-20T15:00:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"15:00","ActualStartTime":"2018-02-20T09:30:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:093000","EndTime":"20180220:100000","ScannerStatus":"0"},{"BookingKey":"S874","StartTime":"2018-02-20T16:00:00.000Z","Duration":"60","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"16:00","ActualStartTime":"2018-02-20T10:30:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:103000","EndTime":"20180220:113000","ScannerStatus":"0"},{"BookingKey":"S873","StartTime":"2018-02-20T17:30:00.000Z","Duration":"60","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"17:30","ActualStartTime":"2018-02-20T12:00:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:120000","EndTime":"20180220:130000","ScannerStatus":"0"},{"BookingKey":"S871","StartTime":"2018-02-20T19:00:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"19:00","ActualStartTime":"2018-02-20T13:30:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:133000","EndTime":"20180220:140000","ScannerStatus":"0"},{"BookingKey":"S870","StartTime":"2018-02-20T19:30:00.000Z","Duration":"60","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"19:30","ActualStartTime":"2018-02-20T14:00:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:140000","EndTime":"20180220:150000","ScannerStatus":"0"},{"BookingKey":"S869","StartTime":"2018-02-20T20:30:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"20:30","ActualStartTime":"2018-02-20T15:00:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:150000","EndTime":"20180220:153000","ScannerStatus":"0"},{"BookingKey":"S872","StartTime":"2018-02-20T21:00:00.000Z","Duration":"30","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"21:00","ActualStartTime":"2018-02-20T15:30:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:153000","EndTime":"20180220:160000","ScannerStatus":"0"},{"BookingKey":"S868","StartTime":"2018-02-20T21:30:00.000Z","Duration":"60","HostName":"Admin iViva","Title":"General Request","Tentative":"0","Label":"21:30","ActualStartTime":"2018-02-20T16:00:00.000Z","HostImagePath":"/AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg","Confirmed":"1","Start":"20180220:160000","EndTime":"20180220:170000","ScannerStatus":"0"}]
     * Color : Green
     * Blink : 0
     * Frequency : 500
     */

    private String Weather;
    private NewsTickerBean NewsTicker;
    private String Color;
    private String Blink;
    private String Frequency;
    private ArrayList<BookingsBean> Bookings;

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String Weather) {
        this.Weather = Weather;
    }

    public NewsTickerBean getNewsTicker() {
        return NewsTicker;
    }

    public void setNewsTicker(NewsTickerBean NewsTicker) {
        this.NewsTicker = NewsTicker;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getBlink() {
        return Blink;
    }

    public void setBlink(String Blink) {
        this.Blink = Blink;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public ArrayList<BookingsBean> getBookings() {
        return Bookings;
    }

    public void setBookings(ArrayList<BookingsBean> Bookings) {
        this.Bookings = Bookings;
    }

    public static class NewsTickerBean {
        /**
         * Text :    *   Rent-a-church spire plan to boost mobile phone coverage   *   Facebook told to stop tracking in Belgium   *   Anger at Google image search 'peace deal'   *   Hot on Instagram - but is it art?
         * FontColor : #000000
         * BKColor : #ffff00
         */

        private String Text;
        private String FontColor;
        private String BKColor;

        public String getText() {
            return Text;
        }

        public void setText(String Text) {
            this.Text = Text;
        }

        public String getFontColor() {
            return FontColor;
        }

        public void setFontColor(String FontColor) {
            this.FontColor = FontColor;
        }

        public String getBKColor() {
            return BKColor;
        }

        public void setBKColor(String BKColor) {
            this.BKColor = BKColor;
        }
    }

    public static class BookingsBean {
        /**
         * BookingKey : S879
         * StartTime : 2018-02-20T13:00:00.000Z
         * Duration : 30
         * HostName : Admin iViva
         * Title : General Request
         * Tentative : 0
         * Label : 13:00
         * ActualStartTime : 2018-02-20T07:30:00.000Z
         * HostImagePath : /AccountResources/profilepics/User.1.168c5466-d98d-44d0-987f-668bb3c2011d.jpg
         * Confirmed : 1
         * Start : 20180220:073000
         * EndTime : 20180220:080000
         * ScannerStatus : 0
         */

        private String BookingKey;
        private String StartTime;
        private String Duration;
        private String HostName;
        private String Title;
        private String Tentative;
        private String Label;
        private String ActualStartTime;
        private String HostImagePath;
        private String Confirmed;
        private String Start;
        private String EndTime;
        private String ScannerStatus;

        public String getBookingKey() {
            return BookingKey;
        }

        public void setBookingKey(String BookingKey) {
            this.BookingKey = BookingKey;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getDuration() {
            return Duration;
        }

        public void setDuration(String Duration) {
            this.Duration = Duration;
        }

        public String getHostName() {
            return HostName;
        }

        public void setHostName(String HostName) {
            this.HostName = HostName;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getTentative() {
            return Tentative;
        }

        public void setTentative(String Tentative) {
            this.Tentative = Tentative;
        }

        public String getLabel() {
            return Label;
        }

        public void setLabel(String Label) {
            this.Label = Label;
        }

        public String getActualStartTime() {
            return ActualStartTime;
        }

        public void setActualStartTime(String ActualStartTime) {
            this.ActualStartTime = ActualStartTime;
        }

        public String getHostImagePath() {
            return HostImagePath;
        }

        public void setHostImagePath(String HostImagePath) {
            this.HostImagePath = HostImagePath;
        }

        public String getConfirmed() {
            return Confirmed;
        }

        public void setConfirmed(String Confirmed) {
            this.Confirmed = Confirmed;
        }

        public String getStart() {
            return Start;
        }

        public void setStart(String Start) {
            this.Start = Start;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getScannerStatus() {
            return ScannerStatus;
        }

        public void setScannerStatus(String ScannerStatus) {
            this.ScannerStatus = ScannerStatus;
        }
    }
}

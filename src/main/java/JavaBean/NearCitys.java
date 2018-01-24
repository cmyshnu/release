package JavaBean;

import java.util.List;

public class NearCitys {

        private int IsNear;
        private String NearLineTip;
        private List<String> RecommendFlights;
        public void setIsNear(int IsNear) {
            this.IsNear = IsNear;
        }
        public int getIsNear() {
            return IsNear;
        }

        public void setNearLineTip(String NearLineTip) {
            this.NearLineTip = NearLineTip;
        }
        public String getNearLineTip() {
            return NearLineTip;
        }

        public void setRecommendFlights(List<String> RecommendFlights) {
            this.RecommendFlights = RecommendFlights;
        }
        public List<String> getRecommendFlights() {
            return RecommendFlights;
        }

    }


<<<<<<< HEAD
package com.weather;

import java.util.List;

/**
 * Created by dan on 2018/4/22.
 */
public class Hewind {
    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101210101","location":"杭州","parent_city":"杭州","admin_area":"浙江","cnty":"中国","lat":"30.28745842","lon":"120.15357971","tz":"+8.00"}
         * update : {"loc":"2018-04-22 13:47","utc":"2018-04-22 05:47"}
         * status : ok
         * now : {"cloud":"50","cond_code":"101","cond_txt":"多云","fl":"32","hum":"52","pcpn":"0.0","pres":"1008","tmp":"30","vis":"10","wind_deg":"211","wind_dir":"西南风","wind_sc":"2","wind_spd":"6"}
         * daily_forecast : [{"cond_code_d":"300","cond_code_n":"306","cond_txt_d":"阵雨","cond_txt_n":"中雨","date":"2018-04-22","hum":"78","mr":"10:42","ms":"05:45","pcpn":"4.6","pop":"92","pres":"1011","sr":"05:26","ss":"18:31","tmp_max":"30","tmp_min":"21","uv_index":"9","vis":"15","wind_deg":"180","wind_dir":"南风","wind_sc":"3-4","wind_spd":"23"},{"cond_code_d":"307","cond_code_n":"305","cond_txt_d":"大雨","cond_txt_n":"小雨","date":"2018-04-23","hum":"82","mr":"11:45","ms":"00:50","pcpn":"3.7","pop":"88","pres":"1009","sr":"05:25","ss":"18:31","tmp_max":"25","tmp_min":"16","uv_index":"6","vis":"14","wind_deg":"4","wind_dir":"北风","wind_sc":"1-2","wind_spd":"8"},{"cond_code_d":"104","cond_code_n":"101","cond_txt_d":"阴","cond_txt_n":"多云","date":"2018-04-24","hum":"74","mr":"12:48","ms":"01:40","pcpn":"0.0","pop":"23","pres":"1015","sr":"05:24","ss":"18:32","tmp_max":"20","tmp_min":"13","uv_index":"4","vis":"18","wind_deg":"355","wind_dir":"北风","wind_sc":"4-5","wind_spd":"28"}]
         * hourly : [{"cloud":"97","cond_code":"104","cond_txt":"阴","dew":"23","hum":"70","pop":"54","pres":"1007","time":"2018-04-22 16:00","tmp":"29","wind_deg":"188","wind_dir":"南风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"22","hum":"76","pop":"59","pres":"1008","time":"2018-04-22 19:00","tmp":"26","wind_deg":"217","wind_dir":"西南风","wind_sc":"1-2","wind_spd":"5"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"21","hum":"82","pop":"70","pres":"1009","time":"2018-04-22 22:00","tmp":"22","wind_deg":"173","wind_dir":"南风","wind_sc":"1-2","wind_spd":"8"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"19","hum":"88","pop":"25","pres":"1009","time":"2018-04-23 01:00","tmp":"21","wind_deg":"174","wind_dir":"南风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"19","hum":"92","pop":"20","pres":"1009","time":"2018-04-23 04:00","tmp":"21","wind_deg":"269","wind_dir":"西风","wind_sc":"1-2","wind_spd":"1"},{"cloud":"100","cond_code":"306","cond_txt":"中雨","dew":"20","hum":"90","pop":"58","pres":"1009","time":"2018-04-23 07:00","tmp":"22","wind_deg":"274","wind_dir":"西风","wind_sc":"1-2","wind_spd":"11"},{"cloud":"100","cond_code":"305","cond_txt":"小雨","dew":"21","hum":"93","pop":"58","pres":"1009","time":"2018-04-23 10:00","tmp":"23","wind_deg":"65","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"100","cond_code":"305","cond_txt":"小雨","dew":"19","hum":"95","pop":"20","pres":"1008","time":"2018-04-23 13:00","tmp":"24","wind_deg":"30","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"7"}]
         * lifestyle : [{"brf":"较舒适","txt":"白天虽然有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。","type":"comf"},{"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","type":"drsg"},{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","type":"flu"},{"brf":"较不宜","txt":"有降水，且风力较强，推荐您在室内进行低强度运动；若坚持户外运动，请选择避雨防风的地点。","type":"sport"},{"brf":"适宜","txt":"有降水，温度适宜，风稍大，在细雨中游玩也别有一番情调，但记得出门要携带雨具。","type":"trav"},{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。","type":"uv"},{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","type":"cw"},{"brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。","type":"air"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean {
            /**
             * cid : CN101210101
             * location : 杭州
             * parent_city : 杭州
             * admin_area : 浙江
             * cnty : 中国
             * lat : 30.28745842
             * lon : 120.15357971
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-04-22 13:47
             * utc : 2018-04-22 05:47
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            /**
             * cloud : 50
             * cond_code : 101
             * cond_txt : 多云
             * fl : 32
             * hum : 52
             * pcpn : 0.0
             * pres : 1008
             * tmp : 30
             * vis : 10
             * wind_deg : 211
             * wind_dir : 西南风
             * wind_sc : 2
             * wind_spd : 6
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 300
             * cond_code_n : 306
             * cond_txt_d : 阵雨
             * cond_txt_n : 中雨
             * date : 2018-04-22
             * hum : 78
             * mr : 10:42
             * ms : 05:45
             * pcpn : 4.6
             * pop : 92
             * pres : 1011
             * sr : 05:26
             * ss : 18:31
             * tmp_max : 30
             * tmp_min : 21
             * uv_index : 9
             * vis : 15
             * wind_deg : 180
             * wind_dir : 南风
             * wind_sc : 3-4
             * wind_spd : 23
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean {
            /**
             * cloud : 97
             * cond_code : 104
             * cond_txt : 阴
             * dew : 23
             * hum : 70
             * pop : 54
             * pres : 1007
             * time : 2018-04-22 16:00
             * tmp : 29
             * wind_deg : 188
             * wind_dir : 南风
             * wind_sc : 1-2
             * wind_spd : 6
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean {
            /**
             * brf : 较舒适
             * txt : 白天虽然有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。
             * type : comf
             */

            private String brf;
            private String txt;
            private String type;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
=======
package com.weather;

import java.util.List;

/**
 * Created by dan on 2018/4/22.
 */
public class Hewind {
    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101210101","location":"杭州","parent_city":"杭州","admin_area":"浙江","cnty":"中国","lat":"30.28745842","lon":"120.15357971","tz":"+8.00"}
         * update : {"loc":"2018-04-22 13:47","utc":"2018-04-22 05:47"}
         * status : ok
         * now : {"cloud":"50","cond_code":"101","cond_txt":"多云","fl":"32","hum":"52","pcpn":"0.0","pres":"1008","tmp":"30","vis":"10","wind_deg":"211","wind_dir":"西南风","wind_sc":"2","wind_spd":"6"}
         * daily_forecast : [{"cond_code_d":"300","cond_code_n":"306","cond_txt_d":"阵雨","cond_txt_n":"中雨","date":"2018-04-22","hum":"78","mr":"10:42","ms":"05:45","pcpn":"4.6","pop":"92","pres":"1011","sr":"05:26","ss":"18:31","tmp_max":"30","tmp_min":"21","uv_index":"9","vis":"15","wind_deg":"180","wind_dir":"南风","wind_sc":"3-4","wind_spd":"23"},{"cond_code_d":"307","cond_code_n":"305","cond_txt_d":"大雨","cond_txt_n":"小雨","date":"2018-04-23","hum":"82","mr":"11:45","ms":"00:50","pcpn":"3.7","pop":"88","pres":"1009","sr":"05:25","ss":"18:31","tmp_max":"25","tmp_min":"16","uv_index":"6","vis":"14","wind_deg":"4","wind_dir":"北风","wind_sc":"1-2","wind_spd":"8"},{"cond_code_d":"104","cond_code_n":"101","cond_txt_d":"阴","cond_txt_n":"多云","date":"2018-04-24","hum":"74","mr":"12:48","ms":"01:40","pcpn":"0.0","pop":"23","pres":"1015","sr":"05:24","ss":"18:32","tmp_max":"20","tmp_min":"13","uv_index":"4","vis":"18","wind_deg":"355","wind_dir":"北风","wind_sc":"4-5","wind_spd":"28"}]
         * hourly : [{"cloud":"97","cond_code":"104","cond_txt":"阴","dew":"23","hum":"70","pop":"54","pres":"1007","time":"2018-04-22 16:00","tmp":"29","wind_deg":"188","wind_dir":"南风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"22","hum":"76","pop":"59","pres":"1008","time":"2018-04-22 19:00","tmp":"26","wind_deg":"217","wind_dir":"西南风","wind_sc":"1-2","wind_spd":"5"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"21","hum":"82","pop":"70","pres":"1009","time":"2018-04-22 22:00","tmp":"22","wind_deg":"173","wind_dir":"南风","wind_sc":"1-2","wind_spd":"8"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"19","hum":"88","pop":"25","pres":"1009","time":"2018-04-23 01:00","tmp":"21","wind_deg":"174","wind_dir":"南风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"99","cond_code":"104","cond_txt":"阴","dew":"19","hum":"92","pop":"20","pres":"1009","time":"2018-04-23 04:00","tmp":"21","wind_deg":"269","wind_dir":"西风","wind_sc":"1-2","wind_spd":"1"},{"cloud":"100","cond_code":"306","cond_txt":"中雨","dew":"20","hum":"90","pop":"58","pres":"1009","time":"2018-04-23 07:00","tmp":"22","wind_deg":"274","wind_dir":"西风","wind_sc":"1-2","wind_spd":"11"},{"cloud":"100","cond_code":"305","cond_txt":"小雨","dew":"21","hum":"93","pop":"58","pres":"1009","time":"2018-04-23 10:00","tmp":"23","wind_deg":"65","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"100","cond_code":"305","cond_txt":"小雨","dew":"19","hum":"95","pop":"20","pres":"1008","time":"2018-04-23 13:00","tmp":"24","wind_deg":"30","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"7"}]
         * lifestyle : [{"brf":"较舒适","txt":"白天虽然有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。","type":"comf"},{"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","type":"drsg"},{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","type":"flu"},{"brf":"较不宜","txt":"有降水，且风力较强，推荐您在室内进行低强度运动；若坚持户外运动，请选择避雨防风的地点。","type":"sport"},{"brf":"适宜","txt":"有降水，温度适宜，风稍大，在细雨中游玩也别有一番情调，但记得出门要携带雨具。","type":"trav"},{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。","type":"uv"},{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。","type":"cw"},{"brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。","type":"air"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean {
            /**
             * cid : CN101210101
             * location : 杭州
             * parent_city : 杭州
             * admin_area : 浙江
             * cnty : 中国
             * lat : 30.28745842
             * lon : 120.15357971
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-04-22 13:47
             * utc : 2018-04-22 05:47
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            /**
             * cloud : 50
             * cond_code : 101
             * cond_txt : 多云
             * fl : 32
             * hum : 52
             * pcpn : 0.0
             * pres : 1008
             * tmp : 30
             * vis : 10
             * wind_deg : 211
             * wind_dir : 西南风
             * wind_sc : 2
             * wind_spd : 6
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 300
             * cond_code_n : 306
             * cond_txt_d : 阵雨
             * cond_txt_n : 中雨
             * date : 2018-04-22
             * hum : 78
             * mr : 10:42
             * ms : 05:45
             * pcpn : 4.6
             * pop : 92
             * pres : 1011
             * sr : 05:26
             * ss : 18:31
             * tmp_max : 30
             * tmp_min : 21
             * uv_index : 9
             * vis : 15
             * wind_deg : 180
             * wind_dir : 南风
             * wind_sc : 3-4
             * wind_spd : 23
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean {
            /**
             * cloud : 97
             * cond_code : 104
             * cond_txt : 阴
             * dew : 23
             * hum : 70
             * pop : 54
             * pres : 1007
             * time : 2018-04-22 16:00
             * tmp : 29
             * wind_deg : 188
             * wind_dir : 南风
             * wind_sc : 1-2
             * wind_spd : 6
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean {
            /**
             * brf : 较舒适
             * txt : 白天虽然有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。
             * type : comf
             */

            private String brf;
            private String txt;
            private String type;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
>>>>>>> 增加图片识别功能

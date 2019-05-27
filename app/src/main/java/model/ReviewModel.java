package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ReviewModel {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("has_more")
        @Expose
        private Boolean hasMore;
        @SerializedName("num_results")
        @Expose
        private Integer numResults;
        @SerializedName("results")
        @Expose

        private List<Result> results = new ArrayList<Result>();

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public Boolean getHasMore() {
            return hasMore;
        }

        public void setHasMore(Boolean hasMore) {
            this.hasMore = hasMore;
        }

        public Integer getNumResults() {
            return numResults;
        }

        public void setNumResults(Integer numResults) {
            this.numResults = numResults;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }
}

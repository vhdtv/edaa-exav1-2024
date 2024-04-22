public class CountryStats {
    private String country;
    private String confederation;
    private Float population_share;
    private Float tv_audience_share;
    private Float gdp_weighted_share;

    public CountryStats(String country, String confederation, float population_share, float tv_audience_share,
            float gdp_weighted_share) {
        this.country = country;
        this.confederation = confederation;
        this.population_share = population_share;
        this.tv_audience_share = tv_audience_share;
        this.gdp_weighted_share = gdp_weighted_share;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public float getPopulation_share() {
        return population_share;
    }

    public void setPopulation_share(float population_share) {
        this.population_share = population_share;
    }

    public float getTv_audience_share() {
        return tv_audience_share;
    }

    public void setTv_audience_share(float tv_audience_share) {
        this.tv_audience_share = tv_audience_share;
    }

    public float getGdp_weighted_share() {
        return gdp_weighted_share;
    }

    public void setGdp_weighted_share(float gdp_weighted_share) {
        this.gdp_weighted_share = gdp_weighted_share;
    }

    @Override
    public String toString() {
        return "CountryStats [country=" + country + ", confederation=" + confederation + ", population_share="
                + population_share + ", tv_audience_share=" + tv_audience_share + ", gdp_weighted_share="
                + gdp_weighted_share + ", toString()=" + super.toString() + "]";
    }
}

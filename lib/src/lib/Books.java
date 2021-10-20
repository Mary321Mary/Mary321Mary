package lib;

public class Books {
    private int    kod;
    private String name;
    private String publish;
    private int    publishYear;
    private String genre;
    private int    price;

    Books(final int kod, final String name, final String publish, final int publishYear,
            final String genre, final int price) {
        this.kod = kod;
        this.setName(name);
        this.setPublish(publish);
        this.setPublishYear(publishYear);
        this.setGenre(genre);
        this.setPrice(price);
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * @return the kod
     */
    public int getKod() {
        return this.kod;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @return the publish
     */
    public String getPublish() {
        return this.publish;
    }

    /**
     * @return the publishYear
     */
    public int getPublishYear() {
        return this.publishYear;
    }

    /**
     * @param genre
     *            the genre to set
     */
    public void setGenre(final String genre) {
        this.genre = genre;
    }

    /**
     * @param kod
     *            the kod to set
     */
    public void setKod(final int kod) {
        this.kod = kod;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * @param publish
     *            the publish to set
     */
    public void setPublish(final String publish) {
        this.publish = publish;
    }

    /**
     * @param publishYear
     *            the publishYear to set
     */
    public void setPublishYear(final int publishYear) {
        this.publishYear = publishYear;
    }

}

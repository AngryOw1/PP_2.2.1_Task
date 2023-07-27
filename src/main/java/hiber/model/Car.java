package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Column(name = "model")
    String model;
    @Column(name = "series")
    int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    @OneToOne(mappedBy = "car")
    private User user;

    @Override
    public String toString() {
        return "car model: " + model + ", series: " + series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

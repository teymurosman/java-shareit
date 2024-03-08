package ru.practicum.shareit.booking.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking {

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "bookings_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booker_id", nullable = false)
    User booker;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    Item item;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    BookingStatus status;

    @Column(name = "start_time", nullable = false)
    LocalDateTime start;

    @Column(name = "end_time", nullable = false)
    LocalDateTime end;
}

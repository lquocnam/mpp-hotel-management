package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDTO;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntry;
import edu.miu.cs401.mpp.hotelmanagement.entity.Status;
import edu.miu.cs401.mpp.hotelmanagement.repository.BookingEntryRepository;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingEntryService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class BookingEntryServiceImpl extends BaseService<BookingEntry, BookingEntryDTO, Long> implements BookingEntryService {
    @Override
    public List<BookingEntryDTO> findByBookingNoAndStatus(String bookingNo, Status status) {
        BookingEntryRepository bookingEntryRepository = (BookingEntryRepository) repository;
        Collection<BookingEntry> list = bookingEntryRepository.findByBookingNoAndStatus(bookingNo, status);
//        return list.stream().map(e -> converter.toDto(e)).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<BookingEntryDTO> findByReferenceID(Integer id) {
        BookingEntryRepository bookingEntryRepository = (BookingEntryRepository) repository;
        Collection<BookingEntry> list = bookingEntryRepository.findByReferenceID(id);
        return list.stream().map(e -> converter.toDto(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingEntryDTO> findByGuestName(String firstName, Status status) {
        BookingEntryRepository bookingEntryRepository = (BookingEntryRepository) repository;
        Collection<BookingEntry> list = bookingEntryRepository.findByGuestName(firstName, status);
        return list.stream().map(e -> converter.toDto(e)).collect(Collectors.toList());
    }
}

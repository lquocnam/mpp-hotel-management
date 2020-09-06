package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.dto.BookingEntryDto;
import edu.miu.cs401.mpp.hotelmanagement.entity.BookingEntry;
import edu.miu.cs401.mpp.hotelmanagement.service.BookingEntryService;
import org.springframework.stereotype.Service;

@Service
public class BookingEntryServiceImpl extends BaseService<BookingEntry, BookingEntryDto, Long> implements BookingEntryService {
}

package spring.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.EmployeeDao;
import spring.dao.IssuedDao;
import spring.dao.ReaderDao;
import spring.dto.IssuedDto;
import spring.dto.ReaderDto;
import spring.models.Issued;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IssuedService {

    private IssuedDao issuedDao;
    private ReaderDao readerDao;
    private EmployeeDao employeeDao;

    public IssuedService(IssuedDao issuedDao, ReaderDao readerDao, EmployeeDao employeeDao) {
        this.issuedDao = issuedDao;
        this.readerDao = readerDao;
        this.employeeDao = employeeDao;
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public List<IssuedDto> findAllIssued() {
        List<Issued> all = this.issuedDao.findAll();
        return getIssued(all);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public List<IssuedDto> findByDateReturnIsNull() {
        List<Issued> byDateReturnIsNull = this.issuedDao.findByDateReturnIsNull();
        return getIssued(byDateReturnIsNull);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public List<IssuedDto> findByBookId(long id) {
        List<Issued> byBookId = this.issuedDao.findByBookId(id);
        return getIssued(byBookId);
    }

    @PreAuthorize("hasAnyAuthority('reader', 'employee')")
    public List<IssuedDto> findByReaderId(long id) {
        List<Issued> byReaderId = this.issuedDao.findByReaderId(id);
        return getIssued(byReaderId);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public List<IssuedDto> findByEmployeeId(long id) {
        List<Issued> byEmployeeId = this.issuedDao.findByEmployeeId(id);
        return getIssued(byEmployeeId);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public IssuedDto saveIssued(IssuedDto issuedDto) {
        Issued issued = new Issued(issuedDto.getId(),
                issuedDto.getBook(),
                this.readerDao.getOne(issuedDto.getReaderDto().getId()),
                this.employeeDao.findByFio(issuedDto.getEmployee()),
                issuedDto.getDateIss(),
                issuedDto.getDateReturn());
        Issued save = this.issuedDao.save(issued);
        return getIssuedDto(save);
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public IssuedDto closeIssued(IssuedDto issuedDto) {
        Issued issued = new Issued(issuedDto.getId(),
                issuedDto.getBook(),
                this.readerDao.getOne(issuedDto.getReaderDto().getId()),
                this.employeeDao.findByFio(issuedDto.getEmployee()),
                issuedDto.getDateIss(),
                Date.valueOf(LocalDate.now()));
        Issued save = this.issuedDao.save(issued);
        return getIssuedDto(save);
    }

    private IssuedDto getIssuedDto(Issued issued) {
        return IssuedDto.builder()
                .id(issued.getId())
                .book(issued.getBook())
                .readerDto(ReaderDto.builder()
                        .id(issued.getReader().getId())
                        .fio(issued.getReader().getFio())
                        .phone(issued.getReader().getPhone())
                        .address(issued.getReader().getAddress())
                        .birthday(issued.getReader().getBirthday()).build())
                .employee(issued.getEmployee().getFio())
                .dateIss(issued.getDateIss())
                .dateReturn(issued.getDateReturn()).build();
    }

    private List<IssuedDto> getIssued(List<Issued> issueds) {
        List<IssuedDto> issuedDtos = new ArrayList<>();
        for (Issued issued: issueds) {
            issuedDtos.add(getIssuedDto(issued));
        }
        return issuedDtos;
    }

}

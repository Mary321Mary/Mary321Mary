package spring.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.BookDao;
import spring.dao.ReaderDao;
import spring.dao.UserDao;
import spring.dto.ReaderDto;
import spring.models.Reader;
import spring.models.User;

@Service
@Transactional
public class ReaderService {

    private ReaderDao readerDao;
    private UserDao userDao;

    public ReaderService(ReaderDao readerDao, UserDao userDao) {
        this.readerDao = readerDao;
        this.userDao = userDao;
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public ReaderDto findReaderByUsername(String username) {
        User byUsername = this.userDao.findByUsername(username);
        Reader reader = this.readerDao.findReaderByUserId(byUsername.getId());
        return ReaderDto.builder()
                .id(reader.getId())
                .fio(reader.getFio())
                .phone(reader.getPhone())
                .address(reader.getAddress())
                .birthday(reader.getBirthday()).build();
    }

    @PreAuthorize("hasAnyAuthority('employee')")
    public ReaderDto findReaderById(Long id) {
        Reader reader = this.readerDao.getOne(id);
        return ReaderDto.builder()
                .id(id)
                .fio(reader.getFio())
                .phone(reader.getPhone())
                .address(reader.getAddress())
                .birthday(reader.getBirthday()).build();
    }

    public ReaderDto saveReader(ReaderDto readerDto) {
        Reader reader = new Reader(readerDto.getId(),
                readerDto.getFio(),
                readerDto.getPhone(),
                readerDto.getAddress(),
                readerDto.getBirthday()//,
                //null
        );
//        if(readerDto.getId() != -1) {
//            reader.setBooks(this.readerDao.getOne(readerDto.getId()).getBooks());
//        }
        Reader save = this.readerDao.save(reader);
        return ReaderDto.builder()
                .id(save.getId())
                .fio(save.getFio())
                .phone(save.getPhone())
                .address(save.getAddress())
                .birthday(save.getBirthday()).build();
    }

    public void deleteReader(long id) {
        this.readerDao.deleteById(id);
    }

}

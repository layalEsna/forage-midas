// package com.jpmc.midascore.repository;

// import com.jpmc.midascore.entity.UserRecord;
// import org.springframework.data.repository.CrudRepository;

// public interface UserRepository extends CrudRepository<UserRecord, Long> {
//     UserRecord findById(long id);
// }
package com.jpmc.midascore.repository;

import com.jpmc.midascore.entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
}

package edu.codeup.codeupspringblog.repository;

import edu.codeup.codeupspringblog.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

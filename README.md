# persist-without-save-jpa
JPA saves Object without invoking save method ( @Transactional Default Behaivour )

When you call updatePersonNameTransactional method in PersonService it automatically saves that do database.

This can cause unwanted db operations use it carefully.

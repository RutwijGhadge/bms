# BOOK MY SHOW
**Book My Show Clone**

Refer the following link to connect & Setup Postgresql through the Terminal on MAC :
https://www.sqlshack.com/setting-up-a-postgresql-database-on-mac/

**Entity Mapping & Relationships**

1. *Unidirectional (1:1)*

    @OnetoOne


2. *BiDirectional (1:1)  (Driver & Licence)*

    @OnetoOne(MappedBy="Attribute name")


3. *Unidirectional (1:M) (School & Classroom)*

    @OnetoMany(JoinColumn())


4. *BiDirectional (1:M) (Author & Book)*   

    Author -> @OneToMany

    Book -> @ManyToOne(MappedBy="AttributeName")


5. *Unidirectional (M:M) (Course & Students)*

    @ManytoMany

    No Need to do Anything (JPA will Create Mapping Table)


6. *BiDirectional (M:M) (Movie & Actor)*
    
    (Mapped By="Attribute Name")
    
    Movie -> @ManytoMany 
    
    Actor -> @ManytoMany


**Serializable Transaction**  
>Allows to read but not the update
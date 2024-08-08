# One-To-Many uni directional Mapping

For acheiving this we need one annotation called as @OneToMany. Here, we will create refrence variable of one class in an another class, that will be annoted with '@OneToMany'. 
- In OneToMany mapping 3 tables will be generated in the database. One is for owning side(company), second is for non-ownig side(Employee) and third is for storing foreing keys (Intermmedidate Table) to achieve relationship.
- This is done because, If two tables are created it violates E.F.Codd's 1st rule(Atomicity) and we have to make primary key of company as duplicate. It is not possible hence, primary keys of both the tables are stored in separate table as foreing keys.

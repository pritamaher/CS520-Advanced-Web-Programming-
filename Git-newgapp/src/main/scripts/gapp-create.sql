
    create table additionalfields (
        additionalfield int4 not null,
        additionalfieldname varchar(255),
        additionalfieldtype varchar(255),
        choice varchar(255),
        department_Department_id int4,
        primary key (additionalfield)
    );

    create table additionalfieldvalues (
        id int4 not null,
        value varchar(255),
        additionalfield_additionalfield int4,
        applicant_id int4,
        application_id int4,
        primary key (id)
    );

    create table applicants (
        id int4 not null,
        cin int4,
        citizenship varchar(255),
        dateofbirth timestamp,
        gender varchar(255),
        gpa float4 not null,
        gre int4,
        phonenumber int8 not null,
        toefl int4,
        transcript varchar(255),
        type varchar(255),
        user_id int4,
        primary key (id)
    );

    create table applicants_educationalbackgrounds (
        applicants_id int4 not null,
        eb_id int4 not null
    );

    create table applications (
        id int4 not null,
        comment varchar(255),
        completedate timestamp,
        lastmodifieddate timestamp,
        startdate timestamp,
        status varchar(255),
        term varchar(255),
        applicant_id int4,
        department_Department_id int4,
        program_id int4,
        user_id int4,
        primary key (id)
    );

    create table departments (
        Department_id int4 not null,
        departmentname varchar(255),
        primary key (Department_id)
    );

    create table educationalbackgrounds (
        id int4 not null,
        collegename varchar(255),
        degree varchar(255),
        degreeearneddate timestamp,
        enddate timestamp,
        major varchar(255),
        startdate timestamp,
        applicant_id int4,
        application_id int4,
        primary key (id)
    );

    create table programs (
        id int4 not null,
        programenddate varchar(255),
        programname varchar(255),
        programstartdate varchar(255),
        programstatus varchar(255),
        department_Department_id int4,
        primary key (id)
    );

    create table staffs (
        id int4 not null,
        firstname varchar(255),
        lastname varchar(255),
        stafftype varchar(255),
        user_id int4,
        primary key (id)
    );

    create table users (
        id int4 not null,
        emailid varchar(255),
        firstname varchar(255),
        lastname varchar(255),
        password varchar(255),
        type varchar(255),
        primary key (id)
    );

    alter table applicants_educationalbackgrounds 
        add constraint UK_sap4dve1nx7xoff3p34c6x4m4 unique (eb_id);

    alter table staffs 
        add constraint UK_hyergys1rxmrdnahwyo060brs unique (firstname);

    alter table staffs 
        add constraint UK_p03ok9mk1sa76u58ere8y94pa unique (lastname);

    alter table users 
        add constraint UK_mnl8vx2peslby5w5qq49edjd4 unique (firstname);

    alter table users 
        add constraint UK_pdm2k8uagx4e5n8bpgw5fvrm9 unique (lastname);

    alter table additionalfields 
        add constraint FK_iu9f82yeq9pdutet5020ymvjm 
        foreign key (department_Department_id) 
        references departments;

    alter table additionalfieldvalues 
        add constraint FK_s499inuqr4nvu3826ioa43nje 
        foreign key (additionalfield_additionalfield) 
        references additionalfields;

    alter table additionalfieldvalues 
        add constraint FK_rkbr0hx0u1qgeg0grm19hs8ne 
        foreign key (applicant_id) 
        references applicants;

    alter table additionalfieldvalues 
        add constraint FK_b2gxe0whigwxfdu7p66hrqjbl 
        foreign key (application_id) 
        references applications;

    alter table applicants 
        add constraint FK_8dcjpq7ywwkgrsen3kr8yfj57 
        foreign key (user_id) 
        references users;

    alter table applicants_educationalbackgrounds 
        add constraint FK_sap4dve1nx7xoff3p34c6x4m4 
        foreign key (eb_id) 
        references educationalbackgrounds;

    alter table applicants_educationalbackgrounds 
        add constraint FK_kmpebfmrynw1xbl4mnqoxfl0q 
        foreign key (applicants_id) 
        references applicants;

    alter table applications 
        add constraint FK_lmcomkxa52fc4kw1pgin4ov1i 
        foreign key (applicant_id) 
        references applicants;

    alter table applications 
        add constraint FK_j43x6dsceamuv9qnlt3onreb3 
        foreign key (department_Department_id) 
        references departments;

    alter table applications 
        add constraint FK_fvv8mt4q3l0jlgem0374rwfb5 
        foreign key (program_id) 
        references programs;

    alter table applications 
        add constraint FK_il296b7i4a8es7mgs2a79gl8o 
        foreign key (user_id) 
        references users;

    alter table educationalbackgrounds 
        add constraint FK_98svccxdbrplxn71du8b47fkf 
        foreign key (applicant_id) 
        references applicants;

    alter table educationalbackgrounds 
        add constraint FK_sluu7q087ktu6c3l4676gxxx3 
        foreign key (application_id) 
        references applications;

    alter table programs 
        add constraint FK_smub4s7qvu0xhuyfthqfxmoso 
        foreign key (department_Department_id) 
        references departments;

    alter table staffs 
        add constraint FK_22xf2k8uqtauv6jjon7g9e069 
        foreign key (user_id) 
        references users;

    create sequence hibernate_sequence START with 100;
;



insert into users values (1,'admin@localhost.localdomain','admin','admin','abcd','admin');
insert into users values (2,'staff1@localhost.localdomain','Andrew','jackson','abcd','staff');
insert into users values (3,'staff2@localhost.localdomain','Jdoe','aguiret','abcd','staff');
insert into users values (4,'student1@localhost.localdomain','john','troung','abcd','student');
insert into users values (5,'student2@localhost.localdomain','jack','amyson','abcd','student');



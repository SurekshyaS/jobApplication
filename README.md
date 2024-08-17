## jobApplication
## Simple Spring web application with a feature to save the front end form to backend and do some quering around that data
### APIS 
GET:/api/saveApplicant
POST:/api/saveApplicant
GET:/api/applicantByState

### Web
http://localhost:8080

FrontEnd Component
jobApplicationForm
List of Applied Candidates
GroupBy State and Count

### Query used
create schema application;
CREATE TABLE application.applicant(
id SERIAL PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(200) NOT NULL,
phone_number VARCHAR(50) NOT NULL,
education VARCHAR (100) NOT NULL,
availability VARCHAR(50) NOT NULL,
job_name VARCHAR (200 )NOT NULL,
address_id INTEGER NOT NULL,
FOREIGN KEY (address_id) REFERENCES application.address(id)

);

CREATE TABLE application.address(
id SERIAL PRIMARY KEY,
street VARCHAR (100) NOT NULL,
state VARCHAR (50) NOT NULL,
city VARCHAR(50) NOT NULL,
zip_code VARCHAR(20) NOT NULL
);

select *
from application.address;

select *
from application.applicant;

ALTER TABLE application.applicant
RENAME COLUMN full_name TO first_name;

SELECT a.state AS state,
COUNT(*) AS applicant_count
FROM application.address a GROUP BY a.state;

SELECT a.state AS state, COUNT(*) AS applicant_count FROM application.address a GROUP BY a.state;
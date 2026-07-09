
INSERT INTO WT_PART
(PART_NUMBER, PART_NAME, REVISION, LIFECYCLE_STATE, CREATED_BY)
VALUES
('PN-1001', 'Gear Housing',        'A', 'INWORK',    'Amit Sharma'),
('PN-1002', 'Drive Shaft',         'A', 'RELEASED',  'Priya Patel'),
('PN-1003', 'Bearing Assembly',    'B', 'INWORK',    'Rahul Verma'),
('PN-1004', 'Motor Bracket',       'A', 'RELEASED',  'Sneha Joshi'),
('PN-1005', 'Cooling Fan',         'C', 'OBSOLETE',  'Vikram Singh'),
('PN-1006', 'Control Panel',       'A', 'INWORK',    'Neha Gupta'),
('PN-1007', 'Hydraulic Pump',      'B', 'RELEASED',  'Arjun Mehta'),
('PN-1008', 'Pressure Valve',      'A', 'INWORK',    'Pooja Desai'),
('PN-1009', 'Sensor Module',       'D', 'RELEASED',  'Karan Malhotra'),
('PN-1010', 'Electrical Harness',  'A', 'INWORK',    'Anjali Nair'),
('PN-1011', 'Mounting Plate',      'B', 'RELEASED',  'Rohit Kulkarni'),
('PN-1012', 'Rotor Assembly',      'A', 'OBSOLETE',  'Meera Iyer'),
('PN-1013', 'Transmission Cover',  'C', 'RELEASED',  'Sandeep Choudhary');

SELECT *
FROM WT_PART
WHERE LIFECYCLE_STATE = 'RELEASED';

SELECT TOP 10 *
FROM WT_PART
ORDER BY CREATED_DATE DESC;

SELECT *
FROM WT_PART
WHERE CREATED_BY = 'Amit Sharma';

SELECT LIFECYCLE_STATE, COUNT(PART_ID) AS PartCount
FROM WT_PART
GROUP BY LIFECYCLE_STATE;
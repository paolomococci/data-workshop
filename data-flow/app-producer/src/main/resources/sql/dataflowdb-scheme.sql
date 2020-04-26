--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL,
  `code` varchar(10) NOT NULL,
  `updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

--
-- Table structure for table `job_customers`
--

DROP TABLE IF EXISTS `job_customers`;
CREATE TABLE `job_customers` (
  `jobs_id` bigint(20) NOT NULL,
  `customers_id` bigint(20) NOT NULL,
  KEY `FK5el1qt53bul4bsk1jwml3wpt3` (`customers_id`),
  KEY `FKddic0cdkxw4fcq320xjuif47p` (`jobs_id`),
  CONSTRAINT `FK5el1qt53bul4bsk1jwml3wpt3` FOREIGN KEY (`customers_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKddic0cdkxw4fcq320xjuif47p` FOREIGN KEY (`jobs_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `job_employees`
--

DROP TABLE IF EXISTS `job_employees`;
CREATE TABLE `job_employees` (
  `jobs_id` bigint(20) NOT NULL,
  `employees_id` bigint(20) NOT NULL,
  KEY `FK4ysvwko367fntmf6yta5g4778` (`employees_id`),
  KEY `FK5bpemohwbirvsk5cue1e3eugp` (`jobs_id`),
  CONSTRAINT `FK4ysvwko367fntmf6yta5g4778` FOREIGN KEY (`employees_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK5bpemohwbirvsk5cue1e3eugp` FOREIGN KEY (`jobs_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

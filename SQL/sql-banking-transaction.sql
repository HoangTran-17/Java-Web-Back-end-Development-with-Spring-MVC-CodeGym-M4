CREATE SCHEMA `sql-banking-transaction` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

--
-- Table structure for table `customers`
--
use `sql-banking-transaction`;
CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `balance` decimal(12,0) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

use `sql-banking-transaction`;
insert into `sql-banking-transaction`.`customers`(`id`,`email`,`full_name`,`phone`) values(12,`hoang.tran@gmail.com`,`Hoang Tran`,`0973333333`);
insert into `sql-banking-transaction`.`customers`(`id`,`email`,`full_name`,`phone`) values(23,`na.ho@gmail.com`,`Na Ho`,`09767433333`);

--
-- Table structure for table `deposits`
--

CREATE TABLE `deposits` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `transaction_amount` decimal(12,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Table structure for table `withdraws`
--

CREATE TABLE `withdraws` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `transaction_amount` decimal(12,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Table structure for table `transfers`
--

CREATE TABLE `transfers` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `fees` int(11) NOT NULL,
  `fees_amount` decimal(12,0) NOT NULL,
  `transaction_amount` decimal(12,0) NOT NULL,
  `transfer_amount` decimal(12,0) NOT NULL,
  `recipient_id` bigint(20) DEFAULT NULL,
  `sender_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


SELECT `sender`.`id`,
		`sender`.`sender_id`,
        `sender`.`sender_name`,
        `sender`.`sender_email`,
        `sender`.`sender_phone`,
        `sender`.`recipient_id`,
        `customers`.`full_name` as `recipient_name`, 
		`customers`.`email` as `recipient_email`, 
		`customers`.`phone` as `recipient_phone`,
		`sender`.`fees_amount`,
        `sender`.`transaction_amount`,
        `sender`.`transfer_amount`
FROM `customers`
INNER JOIN 
	( select `transfers`.`id`,
			`transfers`.`sender_id`,
			`customers`.`full_name` as `sender_name`, 
            `customers`.`email` as `sender_email`, 
            `customers`.`phone` as `sender_phone`,
            `transfers`.`recipient_id`,
            `transfers`.`fees_amount`,
			`transfers`.`transaction_amount`,
			`transfers`.`transfer_amount`
            from `transfers` 
		INNER join `customers` 
        ON `transfers`.`sender_id` = `customers`.`id`) 
        as `sender`
ON `customers`.`id` = `sender`.`recipient_id`;
    

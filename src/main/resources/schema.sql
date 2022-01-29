CREATE TABLE IF NOT EXISTS `user_role` (
                             `id` bigint(20) NOT NULL,
                             `role` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `user_entries` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `email` varchar(255) DEFAULT NULL,
                                `enabled` bit(1) DEFAULT NULL,
                                `first_name` varchar(255) DEFAULT NULL,
                                `last_name` varchar(255) DEFAULT NULL,
                                `locked` bit(1) DEFAULT NULL,
                                `password` varchar(255) DEFAULT NULL,
                                `user_role_id` bigint(20) DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FK4jyxdbc0y03sjaxpb3akor7ne` (`user_role_id`),
                                CONSTRAINT `FK4jyxdbc0y03sjaxpb3akor7ne` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `token` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `confirmed_at` datetime DEFAULT NULL,
                         `created_at` datetime NOT NULL,
                         `expires_at` datetime NOT NULL,
                         `token` varchar(255) NOT NULL,
                         `user_id` bigint(20) NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKqgpgadq95gutkosfj0aj7po3b` (`user_id`),
                         CONSTRAINT `FKqgpgadq95gutkosfj0aj7po3b` FOREIGN KEY (`user_id`) REFERENCES `user_entries` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


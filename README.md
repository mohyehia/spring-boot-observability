# spring-boot-observability
Demo project for exploring spring boot 3 observability stack

## Overview
- [Monitoring](#monitoring)
  - [Monitoring Golden Signals](#monitoring-golden-signals)
  - [Monitoring Best Practices](#monitoring-best-practices)
- [Observability](#observability)
  - [Pillars of Observability](#pillars-of-observability)
  - [Observability Best Practices](#observability-best-practices)
- [Observability vs Monitoring](#observability-vs-monitoring)
- [Similarities between Observability & Monitoring](#similarities-between-observability--monitoring)
- [References](#references)

### Monitoring
- Monitoring is the process of collecting, analyzing, and using information to track a program’s progress toward reaching its objectives and to guide management decisions.
- Monitoring focuses on watching specific metrics.
- Logging provides additional data but is typically viewed in isolation of a broader system context.

#### Monitoring Golden Signals
- **Latency**
  - Time taken for the request to travel from the client to the server and back
- **Traffic**
  - Number of requests a system receives over a specific period
- **Errors**
  - Percentage of requests resulting in errors, such as `404 Page Not Found` or `500 Internal Server Error`
- **Saturation**
  - Measures resource utilization, including CPU, memory & disk space

#### Monitoring Best Practices
- Monitoring should be applied as early as possible.
- Know exactly what things should be monitored and be aware that this list might change over time based on the project situation.
- Pay attention to the above golden signals for metrics.
- Send alerts that are easy to understand and are right to the point.
- Don't send too many alerts because people may start ignoring them.

### Observability
- Observability is the ability to understand a system’s internal state by analyzing the data it generates, such as logs, metrics, and traces.
- Observability helps teams analyze what’s happening in context across multi-cloud environments, so you can detect and resolve the underlying causes of issues.

#### Pillars of Observability
- According to engineers at `google`, 2 pillars of observability:
  - **Logs**
    - Logs provide a chronological record of events, or transactions within a system
    - Logs provide insights into when something happened and what exactly happened
  - **Metrics**
    - Metrics are quantitative measurements that offer a snapshot of a system performance over time
    - These include numerical values such as response times, error rates & resource utilization
  - **Traces**
    - Helps track the flow of requests through various services and components of a system
- The higher the level of observability the system has, The quicker we can find the root cause when ever we get notified about an issue.

#### Observability Best Practices
- Decide what exactly to log as the count and size of the logs can quickly increase over time so that you can have some control over the cost of the storage.
- Cleanup logs whenever not needed.

### Observability vs Monitoring
- In general, `Observability` is a broader concept that includes `Monitoring`.
- `Monitoring` alerts us when something goes wrong, while `Observability` helps us to understand why there is an error and how to fix it.
- `Monitoring` has limited information about the issue, while `Observability` has complete information about the issue via logs.

### Similarities between Observability & Monitoring
- Observability and monitoring are closely related concepts in software engineering.
- Both aim to provide insights into the health, performance, and behavior of a system.
- They utilize data collection, analysis, and visualization techniques to enable proactive detection and troubleshooting of issues.
- Ultimately, they empower engineers to ensure system reliability, performance optimization, and efficient resource utilization.


### References
- [Observability vs. Monitoring](https://www.youtube.com/watch?v=vY61h6cSkVA)
- [Spring Boot 3 Observability](https://www.youtube.com/playlist?list=PLLMxXO6kMiNiwHCayWk74XynT5tvoMa4u)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
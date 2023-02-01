# Conference Reservation App

Provides REST API for CRUD operations with Conference resource.

For API documentation please refer ./docs/normalized/openapi.yaml.
API can be utilized and tested via Postman using that openapi specification.

Description: Creation of new Conference includes operations of reservation of accommodation (Room) with
a requested capacity for requested time span (scheduleSlot).
Capacity of the room is relevant with number of conference participants.
Number of participants (headcount) can be adjusted/updated via API.
To meet and implement this business logic, Conference object is designed to have relevant
properties.


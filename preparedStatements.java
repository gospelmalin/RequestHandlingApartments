  public static void updateStatus(int request_id) {

        // connect to db
        dbConnect();

        //

        try {
            Statement stmt = conn.prepareStatement("UPDATE request SET status_id = 2 WHERE request_id = ?");
            ((PreparedStatement) stmt).setString(1, Integer.toString(request_id));

            ResultSet resultSet = ((PreparedStatement) stmt).executeQuery();
            

        } catch (SQLException e) {
            System.err.println("An SQL exception occured when while executing query " + e);
        }

        // close db
        dbClose();

    }


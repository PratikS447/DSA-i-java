package org.example.Tree.Binary_Search_Tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializationAndDeserializationTest {

    private static Node node(int val, Node left, Node right) {
        Node n = new Node(val);
        n.left = left;
        n.right = right;
        return n;
    }

    private static Node leaf(int val) {
        return node(val, null, null);
    }

    @Test
    @DisplayName("Serialize null root gives just the null marker")
    void testSerializeNullRoot() {
        // Arrange
        Node root = null;

        // Act
        String result = Serialization_and_Deserialization.Serialization(root);

        // Assert
        assertEquals("#,", result);
    }

    @Test
    @DisplayName("Serialize single node gives value then two null markers")
    void testSerializeSingleNode() {
        // Arrange
        Node root = leaf(5);

        // Act
        String result = Serialization_and_Deserialization.Serialization(root);

        // Assert
        assertEquals("5,#,#,", result);
    }

    @Test
    @DisplayName("Serialize small tree follows preorder with null markers")
    void testSerializeSmallTree() {
        // Arrange:      1
        //              / \
        //             2   3
        Node root = node(1, leaf(2), leaf(3));

        // Act
        String result = Serialization_and_Deserialization.Serialization(root);

        // Assert
        assertEquals("1,2,#,#,3,#,#,", result);
    }

    @Test
    @DisplayName("Deserialize null marker gives null root")
    void testDeserializeNullRoot() {
        // Arrange
        String data = "#,";

        // Act
        Node result = Serialization_and_Deserialization.deserialization(data);

        // Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Deserialize single node string rebuilds a leaf node")
    void testDeserializeSingleNode() {
        // Arrange
        String data = "5,#,#,";

        // Act
        Node result = Serialization_and_Deserialization.deserialization(data);

        // Assert
        assertNotNull(result);
        assertEquals(5, result.data);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    @DisplayName("Round trip on small tree reproduces same serialized form")
    void testRoundTripSmallTree() {
        // Arrange:      1
        //              / \
        //             2   3
        //            /
        //           4
        Node original = node(1, node(2, leaf(4), null), leaf(3));

        // Act
        String serialized = Serialization_and_Deserialization.Serialization(original);
        Node rebuilt = Serialization_and_Deserialization.deserialization(serialized);
        String reserialized = Serialization_and_Deserialization.Serialization(rebuilt);

        // Assert
        assertEquals(serialized, reserialized);
        assertEquals(1, rebuilt.data);
        assertEquals(2, rebuilt.left.data);
        assertEquals(3, rebuilt.right.data);
        assertEquals(4, rebuilt.left.left.data);
    }

    @Test
    @DisplayName("Round trip on a larger skewed tree — likely to expose == vs equals bug")
    void testRoundTripLargerSkewedTree() {
        // Arrange: a longer left-skewed chain, built at runtime (not interned literals)
        Node root = leaf(1);
        Node cursor = root;
        for (int i = 2; i <= 20; i++) {
            Node next = leaf(i);
            cursor.left = next;
            cursor = next;
        }

        // Act
        String serialized = Serialization_and_Deserialization.Serialization(root);
        Node rebuilt = Serialization_and_Deserialization.deserialization(serialized);

        // Assert: walk down the left spine and check every value matches
        Node walker = rebuilt;
        for (int i = 1; i <= 20; i++) {
            assertNotNull(walker, "Tree truncated early at expected node " + i);
            assertEquals(i, walker.data);
            walker = walker.left;
        }
        assertNull(walker);
    }

    @Test
    @DisplayName("Deserializing a data string built via String.valueOf avoids literal interning")
    void testDeserializeWithNonInternedHashMarker() {
        // Arrange: construct "#" via concatenation at runtime so it is NOT
        // the same interned literal as any "#" that might appear in source —
        // this is the case most likely to break with == comparison
        String hash = new String(new char[]{'#'});
        String data = "7," + hash + "," + hash + ",";

        // Act
        Node result = Serialization_and_Deserialization.deserialization(data);

        // Assert
        assertNotNull(result);
        assertEquals(7, result.data);
        assertNull(result.left);
        assertNull(result.right);
    }
}